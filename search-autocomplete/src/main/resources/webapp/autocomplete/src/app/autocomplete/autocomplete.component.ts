import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-autocomplete',
  templateUrl: './autocomplete.component.html',
  styleUrls: ['./autocomplete.component.scss']
})
export class AutocompleteComponent implements OnInit {
  queryText: string = "";

  constructor() { }

  ngOnInit(): void {
  }
  //
  // onChange(UpdatedValue : string) :void
  // {
  //   this.queryText = UpdatedValue;
  // }
}
