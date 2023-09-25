import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ClienteModel } from '../shared/models/cliente.model';
import { ClienteService } from '../shared/services/cliente.service';
import { EmpregoService } from '../shared/services/emprego.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.less']
})
export class ClienteComponent implements OnInit {
  @ViewChild('closeButton') closeButton: any;

  showAction: boolean = false;
  clientes: Array<ClienteModel> = [];
  clienteSelecionado: ClienteModel;
  action: string = 'edit';
  title: string = '';
  form: FormGroup = new FormGroup({
    nome: new FormControl({value: '', disabled: this.action == 'view'}),
    cpf: new FormControl({value: '', disabled: this.action == 'view'}),
    rg: new FormControl({value: '', disabled: this.action == 'view'}),
    cnh: new FormControl({value: '', disabled: this.action == 'view'}),
    dataNascimento: new FormControl({value: '', disabled: this.action == 'view'}),
    endereco: new FormControl({value: '', disabled: this.action == 'view'})
  });

  formEmprego: FormGroup = new FormGroup({
    descricao1: new FormControl(''),
    renda1: new FormControl(''),
    descricao2: new FormControl(''),
    renda2: new FormControl(''),
    descricao3: new FormControl(''),
    renda3: new FormControl('')
  });

  constructor(private clienteService: ClienteService,
    private empregoService: EmpregoService,
    private router: Router) { }

  ngOnInit(): void {
    this.getClientes();
  }

  salvar() {
    switch (this.action) {
      case 'create':
        this.clienteService.saveCliente(this.form.value).then(resp => {
          this.createEmpregos(resp as ClienteModel)
          this.router.navigate(['cliente'])
        }).catch(error => {
          this.switchAction();
        });
        break;
      case 'edit':
        this.clienteService.updateCliente(this.form.value, this.clienteSelecionado.id).then(resp => {
          this.getClientes();
          this.switchAction();
        }).catch(error => {
          this.switchAction();
        });;
        break;

      default:
        break;
    }
  }

  deletar(cliente: ClienteModel) {
    this.clienteService.deleteCliente(cliente.id).then(
      resp => this.getClientes()
    ).catch(error =>
      this.getClientes()
    )
  }

  setAction(action: string, cliente: ClienteModel | null = null) {
    this.action = action;
    switch (action) {
      case 'view':
        this.title = 'Visualizar Cliente'
        if(cliente) 
          this.clienteSelecionado = cliente;
        this.showAction = true;
        break;

      case 'edit':
        this.title = 'Editar Cliente'
        if(cliente) 
          this.clienteSelecionado = cliente;
        this.showAction = true;
        break;

      case 'create':
        this.title = 'Incluir Cliente'
        this.showAction = true;
        break;

      default:
        break;
    }
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

  canSave(): boolean {
    return this.action !== 'view'
  }

  createEmpregos(cliente: ClienteModel) {
    if(this.formEmprego.controls['descricao1'].value) {
      this.empregoService.create({
        descricao: this.formEmprego.controls['descricao1'].value,
        renda: this.formEmprego.controls['renda1'].value,
        ativo: true,
        cliente: cliente
      });
    }
    if(this.formEmprego.controls['descricao2'].value) {
      this.empregoService.create({
        descricao: this.formEmprego.controls['descricao2'].value,
        renda: this.formEmprego.controls['renda2'].value,
        ativo: true,
        cliente: cliente
      });
    }
    if(this.formEmprego.controls['descricao3'].value) {
      this.empregoService.create({
        descricao: this.formEmprego.controls['descricao3'].value,
        renda: this.formEmprego.controls['renda3'].value,
        ativo: true,
        cliente: cliente
      });
    }
  }

}
