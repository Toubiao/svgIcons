import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';
import {IconListDTO} from '../models/iconListDTO';
import { environment } from '../../environments/environment';

const SVG_ICONS_API = environment.apiUrl.concat('/api/v1/icons');
@Injectable({
  providedIn: 'root'
})
export class SvgIconsService {

  constructor(private http: HttpClient) { }

  getIcons(): Observable<IconListDTO[]> {
    return this.http.get<IconListDTO[]>(SVG_ICONS_API).pipe(catchError(this.handleError<IconListDTO[]>('getSchemas')));
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
