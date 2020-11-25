import {NgModule} from '@angular/core';
import { AdminMoviesComponent } from './admin-movies/admin-movies.component';
import {AdministrationComponent} from './administration.component';
import {CommonModule} from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import { AdminMoviesEditComponent } from './admin-movies/admin-movies-edit/admin-movies-edit.component';
import {AppRoutingModule} from '../app-routing.module';

@NgModule({
  imports: [
    CommonModule, NgbModule, FormsModule, AppRoutingModule
  ],
  declarations: [AdministrationComponent, AdminMoviesComponent, AdminMoviesEditComponent],
})
export class AdministrationModule {
}
