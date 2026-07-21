import { Routes } from '@angular/router';
import { Login } from './components/layout/login/login';
import { Principal } from './components/layout/principal/principal';
import { Carro } from './models/carro';
import { Carrosdetails } from './components/carros/carrosdetails/carrosdetails';
import { Marca } from './models/marca';
import { Marcasdetails } from './components/marcas/marcasdetails/marcasdetails';

export const routes: Routes = [
    {path: "", redirectTo: "login", pathMatch : 'full'},
    {path: "login", component: Login},
    {path: "admin", component: Principal, children: [ // Tem o <app-menu> e o <router-outlet> no HTML dele
        {path: "carros", component: Carro}, // Renderiza dentro do outlet do Principal
        {path: "carros/new", component: Carrosdetails},
        {path: "carros/edit/:id", component: Carrosdetails},
        {path: "marcas", component: Marca}, 
        {path: "marcas/new", component: Marcasdetails},
        {path: "marcas/edit/:id", component: Marcasdetails}
    ]}
];
