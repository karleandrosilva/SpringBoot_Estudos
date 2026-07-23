import { Component } from '@angular/core';
import { Carro } from '../../../models/carro';

@Component({
  selector: 'app-carroslist',
  imports: [],
  templateUrl: './carroslist.html',
  styleUrl: './carroslist.scss',
})
export class Carroslist {

  // criar uma lista 
  lista : Carro[] = [];

  //
  constructor() {
    this.lista.push(new Carro(1, 'Fiesta'));
    this.lista.push(new Carro(2, 'Monza'));
    this.lista.push(new Carro(3, 'Uno'));
  }

}
