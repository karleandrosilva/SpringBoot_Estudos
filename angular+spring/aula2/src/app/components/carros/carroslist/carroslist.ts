import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-carroslist',
  imports: [RouterLink],
  templateUrl: './carroslist.html',
  styleUrl: './carroslist.scss',
})
export class Carroslist {

  // cria uma lista 
  lista : Carro[] = [];

  // inicializa a lista com alguns carros já adicionados
  constructor() {
    this.lista.push(new Carro(1, 'Fiesta'));
    this.lista.push(new Carro(2, 'Monza'));
    this.lista.push(new Carro(3, 'Uno'));
  }

  editar() {

  }

  deletar() {

  }

}
