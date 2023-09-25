import { Component, OnInit, ViewChild } from '@angular/core';
import { AluguelModel } from '../shared/models/aluguel.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AluguelService } from '../shared/services/aluguel.service';
import { ClienteModel } from '../shared/models/cliente.model';
import { ClienteService } from '../shared/services/cliente.service';

@Component({
  selector: 'app-aluguel',
  templateUrl: './aluguel.component.html',
  styleUrls: ['./aluguel.component.less']
})
export class AluguelComponent implements OnInit {
  @ViewChild('closeButton') closeButton: any;

  showAction: boolean = false;
  alugueis: Array<AluguelModel> = [];
  clientes: Array<ClienteModel> = [];
  action: string = 'create';
  title: string = '';
  form: FormGroup = new FormGroup({
    automovel: new FormControl(''),
    statusContrato: new FormControl('EM ANDAMENTO'),
    valorAluguel: new FormControl(''),
    dataInicio: new FormControl(''),
    dataFim: new FormControl(''),
    valorCaucao: new FormControl(''),
    cliente: new FormControl('')
  });

  constructor(private aluguelService: AluguelService,
              private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.getAlugueis();
    this.getClientes();
  }

  salvar() {
    let req = this.form.value;
    req.cliente = this.clientes.find(x => x.id == req.cliente);
    switch (this.action) {
      case 'create':
        this.aluguelService.create(req).then(resp => {
          this.getAlugueis();
          this.switchAction();
        }).catch(error => {
          this.switchAction();
        });
        break;

      default:
        break;
    }
  }

  setAction(action: string) {
    this.action = action;
    switch (action) {
      case 'create':
        this.title = 'Incluir Aluguel'
        this.showAction = true;
        break;

      default:
        break;
    }
  }

  getAlugueis() {
    this.aluguelService.getAll().then(resp => {
      this.alugueis = resp.content;
    })
  }

  getClientes() {
    this.clienteService.getAllCliente().then(resp => {
      this.clientes = resp.content;
    }).catch(error => {
      console.log(error);
    })
  }

  switchAction() {
    this.showAction = false;
  }

}

