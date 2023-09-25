import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AluguelRoutingModule } from './aluguel-routing.module';
import { AluguelComponent } from './aluguel.component';

@NgModule({
  declarations: [
    AluguelComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AluguelRoutingModule
  ]
})
export class AluguelModule { }
