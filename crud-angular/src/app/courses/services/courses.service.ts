import { Course } from './../models/course';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { delay, first, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  private readonly API = 'api/courses';

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Course[]>(this.API)
    .pipe(
      first(),
      delay(3000),
      tap(courses => console.log(courses))
    );
  }

  findById(id: string) {
    return this.httpClient.get<Course>(`${this.API}/${id}`);
  }

  save(record: Course) {
    return record.id ? this.update(record) : this.create(record);
  }

  delete(id: string) {
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }

  private create(record: Course) {
    return this.httpClient.post<Course>(this.API, record);
  }

  private update(record: Partial<Course>) {
    return this.httpClient.put<Course>(`${this.API}/${record.id}`, record);
  }
}
