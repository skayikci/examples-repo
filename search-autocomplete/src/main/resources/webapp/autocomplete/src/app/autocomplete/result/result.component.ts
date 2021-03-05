import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AutocompleteService} from '../autocomplete.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.scss']
})
export class ResultComponent implements OnInit, OnChanges {
  @Input() query: string = '';

  searchResult = [{
    name: 'test',
    description: 'test'
  }];

  searchResultFromServer: Observable<any> | undefined;


  constructor(private autocompleteService: AutocompleteService) {
  }

  ngOnInit(): void {
    this.searchResultFromServer = undefined;
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.searchResultFromServer = this.autocompleteService.getAutocompleteResult(this.query);
  }

}
