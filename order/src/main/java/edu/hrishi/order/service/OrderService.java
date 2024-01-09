package edu.hrishi.order.service;

import edu.hrishi.order.dto.OrderDto;
import edu.hrishi.order.dto.OrderDtoFE;
import edu.hrishi.order.dto.UserDto;
import edu.hrishi.order.entity.Order;
import edu.hrishi.order.mapper.OrderMapper;
import edu.hrishi.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final SequenceGenerator sequenceGenerator;
    private final RestTemplate restTemplate;
    public OrderDto save(OrderDtoFE orderDtoFE) {
        Integer id = sequenceGenerator.generateNextOrderId();
        UserDto userDto = getUserDetailsById(orderDtoFE.getUserId());
        Order orderToSave = new Order(id, orderDtoFE.getLstFoodItem(), orderDtoFE.getRestaurant(), userDto);
        Order orderToReturn = orderRepository.save(orderToSave);
        return OrderMapper.INSTANCE.orderToOrderDto(orderToReturn);
    }
    private UserDto getUserDetailsById(Integer userId) {
        return restTemplate.getForObject("http://user-service/user", UserDto.class);
    }
}
