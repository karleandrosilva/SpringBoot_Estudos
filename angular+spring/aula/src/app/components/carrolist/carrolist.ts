import { Component } from '@angular/core';
import { Carro } from '../../models/carro';

@Component({
  selector: 'app-carrolist',
  imports: [],
  templateUrl: './carrolist.html',
  styleUrl: './carrolist.scss',
})
export class Carrolist {

  lista : Carro[] = [];

  constructor(){
    let carro : Carro = new Carro();
    carro.id = 1;
    carro.nome = "Fiesta";
    carro.marca = "Ford";

    let carro2 : Carro = new Carro();
    carro.id = 2;
    carro.nome = "Uno";
    carro.marca = "Fiat";

    let carro3 : Carro = new Carro();
    carro.id = 3;
    carro.nome = "HB20";
    carro.marca = "Hydain";
  }

}
