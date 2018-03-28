import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { PratoComponent } from './prato/prato.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import {Routes, RouterModule, Router} from "@angular/router";
import { PessoaComponent } from 'app/pessoa/pessoa.component';
import { PessoaService } from 'app/pessoa/pessoa.service';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', redirectTo: 'home'},
  {path: 'pessoa', component: PessoaComponent},
  //{path: 'grafico', component: GraficoComponent},
  {path: '**', component: HomeComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    PessoaComponent,
    //GraficoComponent,
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(routes, {useHash: true})
  ],
  providers: [PessoaService],
  bootstrap: [AppComponent]
})
export class AppModule { }