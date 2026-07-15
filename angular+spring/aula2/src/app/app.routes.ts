import { Routes } from '@angular/router';
import { Login } from './components/layout/login/login';
import { Principal } from './components/layout/principal/principal';
import { Carro } from './models/carro';
import { Carrosdetails } from './components/carros/carrosdetails/carrosdetails';

export const routes: Routes = [
    {path: "", redirectTo: "login", pathMatch : 'full'},
    {path: "login", component: Login},
    {path: "admin", component: Principal, children: [ // Tem o <app-menu> e o <router-outlet> no HTML dele
        {path: "carros", component: Carro}, // Renderiza dentro do outlet do Principal
        {path: "carros/new", component: Carrosdetails},
        {path: "carros/edit/:id", component: Carrosdetails}
    ]}
];
