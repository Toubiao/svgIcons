import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs";
import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';

const SVG_ICONS_API = 'http://hos6dev.xyz:8080/api/v1/icons';
@Injectable({
  providedIn: 'root'
})
export class SvgIconsService {

  constructor(private http: HttpClient) { }

  getIcons(): Observable<any[]> {
    return this.http.get<any[]>(SVG_ICONS_API).pipe(catchError(this.handleError<any[]>('getSchemas')));
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
