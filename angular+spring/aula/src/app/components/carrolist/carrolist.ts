import { Component } from '@angular/core';
import { Carro } from '../../models/carro';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carrolist',
  imports: [CommonModule],
  templateUrl: './carrolist.html',
  styleUrl: './carrolist.scss',
})
export class Carrolist {

  lista : Carro[] = []; // lista vazia de objetos do tipo carro

  constructor(){ // quando for construido apartir de uma rota, vai ser alimentada de forma fixa
    let carro : Carro = new Carro(); // let = usa para declarar var e obj dentro de métodos
    carro.id = 1;
    carro.nome = "Onix";
    carro.marca = "Ford";

    let carro2 : Carro = new Carro();
    carro2.id = 2;
    carro2.nome = "Uno";
    carro2.marca = "Fiat";

    let carro3 : Carro = new Carro();
    carro3.id = 3;
    carro3.nome = "HB20";
    carro3.marca = "Hydain";

    this.lista.push(carro);
    this.lista.push(carro2);
    this.lista.push(carro3);
  }

}
