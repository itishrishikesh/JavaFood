import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CatalogueRoutingModule } from './catalogue-routing.module';
import { CatalogueComponent } from './component/catalogue.component';


@NgModule({
  declarations: [
    CatalogueComponent
  ],
  imports: [
    CommonModule,
    CatalogueRoutingModule
  ],
  exports: [
    CatalogueComponent
  ]
})
export class CatalogueModule { }
