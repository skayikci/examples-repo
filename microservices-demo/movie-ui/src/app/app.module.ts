import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CarouselComponent} from './carousel/carousel.component';
import {CarouselItemComponent} from './carousel/carousel-item/carousel-item.component';
import {NgbRatingModule} from '@ng-bootstrap/ng-bootstrap';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {AppRoutingModule} from './app-routing.module';
import {AdministrationModule} from './administration/administration.module';

@NgModule({
  declarations: [
    AppComponent,
    CarouselComponent,
    CarouselItemComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    NgbRatingModule,
    AppRoutingModule,
    AdministrationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
