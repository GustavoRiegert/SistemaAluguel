import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../shared/services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {

  form = new FormGroup({
    login: new FormControl(''),
    senha: new FormControl('')
  })

  constructor(
    private router: Router,
    private usuarioService: UsuarioService
  ) { }

  ngOnInit(): void {
    
  }

  login( ) {
    this.usuarioService.login(this.form.value).then(
      resp => this.router.navigate(['cliente'])
    ).catch(error => console.log(error));
  }

}
