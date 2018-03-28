import { Component, OnInit } from '@angular/core';
import { Prato } from 'app/entity/prato';
import { PratoService } from 'app/prato/prato.service';
import { RestauranteService } from '../restaurante/restaurante.service';
import { Restaurante } from '../entity/restaurante';

@Component({
  selector: 'app-prato',
  templateUrl: './prato.component.html',
  styleUrls: ['./prato.component.css']
})
export class PratoComponent implements OnInit {
  restaurantes: Array<Restaurante>;
  restauranteRequest = new Restaurante();
  pratos: Array<Prato>;
  pratoRequest = new Prato();
  pratoResponse = new Prato();
  pratoEdit = new Prato();
  newPratoRequest = new Prato();
  msg: string;
  constructor(private pratoService: PratoService) { }

  ngOnInit() {
    this.readAll();
    this.readAllRestaurantes();
  }
  pesquisarPrato(prato: Prato) {
    if (prato.nome === null) {
      this.readAll();
    } else {
      this.pratoService.readByExample(prato)
        .then(
          data => {
            this.pratos = data;
          }
        );
    }
  }
  readAll() {
    this.pratoService.readAll()
      .then(
        data => {
          this.pratos = data;
        }
      );
  }
  readAllRestaurantes() {
    this.pratoService.readAllRestaurantes()
      .then(
        data => {
          this.restaurantes = data;
        }
      );
  }
  create(prato: Prato) {
    prato.restaurante = this.restauranteRequest;
    this.pratoService.create(prato)
      .then(
        data => {
          this.pratoResponse = data[1];
          this.msg = data[2];
          document.getElementById("successCreate").removeAttribute("hidden");
          this.readAll();
        }
      );
  }
  update(prato: Prato) {
    this.pratoService.update(prato)
      .then(
        data => {
          this.pratoResponse = data[1];
          this.msg = data[2];

          document.getElementById("successEdit").removeAttribute("hidden");
        }
      );
  }
  delete(prato: Prato) {
    this.pratoService.delete(prato).then(
      data => {
        this.msg = data;
      }
    );
    this.readAll();
  }

}
