import { Routes } from '@angular/router';
import { Carrolist } from './components/carrolist/carrolist';
import { Dashboard } from './components/dashboard/dashboard';

export const routes: Routes = [
    // Quando o usuário acessar a rota raiz (""), será redirecionado automaticamente para "/carros".
    // O pathMatch: 'full' garante que isso só aconteça quando o caminho estiver completamente vazio.
    {path: "", redirectTo : "carros", pathMatch : 'full'},
    {path: "carros", component : Carrolist},
     {path: "dashboard", component : Dashboard}
];
