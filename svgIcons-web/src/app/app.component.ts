import {Component, OnInit} from '@angular/core';
import {SvgIconsService} from './services/svg-icons.service';
import {IconListDTO} from './models/iconListDTO';
import {Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  icons: IconListDTO[] = [];
  posts: IconListDTO[] = [];
  index: number = 0;

  constructor(private svgIconsService: SvgIconsService) {
  }

  ngOnInit() {
    this.svgIconsService.getIcons().subscribe({
      next: value => {
        this.icons = value;
        this.posts = this.icons.slice(this.index,this.index + 2);
        console.log(this.posts);
      },
      error: err => {

      }
    });
  }

  onScroll() {
    this.index += (this.icons.length - this.index >= 1) ? 2 : 1 ;
    if (this.index < this.icons.length) {
      this.posts = this.posts.concat(this.icons.slice(this.index,this.index + 2));
    }
  }
}

