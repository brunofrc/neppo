import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../entity/Pessoa';
import { PessoaService } from 'app/Pessoa/Pessoa.service';

@Component({
  selector: 'app-pessoa',
  templateUrl: './Pessoa.component.html',
  styleUrls: ['./Pessoa.component.css']
})
export class PessoaComponent implements OnInit {
  pessoas: Array<Pessoa>;
  pessoaRequest = new Pessoa();
  pessoaResponse = new Pessoa();
  pessoaEdit = new Pessoa();
  newPessoaRequest = new Pessoa();
  msg: string;
  
  constructor(private PessoaService: PessoaService) { }

  ngOnInit() {
    this.readAll();
  }
  readAll() {
    this.PessoaService.readAll()
      .then(
        data => {
          this.pessoas = data;
        }
      );
  }
  create(pessoa: Pessoa) {
    this.PessoaService.create(pessoa)
      .then(
        data => {
          this.pessoaResponse = data[1];
          this.msg = data[2];
          document.getElementById("successCreate").removeAttribute("hidden");
          this.readAll();
        }
      );
  }
  update(pessoa: Pessoa) {
    this.PessoaService.update(pessoa)
      .then(
        data => {
          this.pessoaResponse = data[1];
          this.msg = data[2];

          document.getElementById("successEdit").removeAttribute("hidden");
        }
      );
  }
  delete(pessoa: Pessoa) {
    this.PessoaService.delete(pessoa).then(
      data => {
        this.msg = data;
      }
    );
    this.readAll();
  }
}
