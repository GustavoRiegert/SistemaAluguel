import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AluguelComponent } from './aluguel.component';

const routes: Routes = [
  { path: 'aluguel', component: AluguelComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AluguelRoutingModule { }
