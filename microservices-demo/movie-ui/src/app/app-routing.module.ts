import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

import {AdministrationComponent} from './administration/administration.component';
import {CarouselComponent} from './carousel/carousel.component';
import {SelectivePreloadingStrategyService} from './selective-preloading-strategy.service';
import {AdminMoviesEditComponent} from './administration/admin-movies/admin-movies-edit/admin-movies-edit.component';

const appRoutes: Routes = [
  {
    path: 'movie',
    component: CarouselComponent
  },
  {
    path: 'admin',
    component: AdministrationComponent
  },
  {
    path: 'admin/movie/edit',
    component: AdminMoviesEditComponent
  },
  { path: '',   redirectTo: '/movie', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
