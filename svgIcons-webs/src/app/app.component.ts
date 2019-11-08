import {Component, OnInit} from '@angular/core';
import {SvgIconsService} from './services/svg-icons.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  icons : any[] = [];
  constructor(private svgIconsService: SvgIconsService) {


  }

  ngOnInit(){
    this.svgIconsService.getIcons().subscribe({
      next: value => {
        this.icons = value;
      },
      error: err => {

      }
    });
  }

}

