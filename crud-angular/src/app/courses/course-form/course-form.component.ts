import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

import { CoursesService } from './../services/courses.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss']
})
export class CourseFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: CoursesService,
    private _snackBar: MatSnackBar,
    private location: Location) {
    this.form = formBuilder.group( {
      name: [null],
      category : [null]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(result => this.onSuccess(), error => this.onError());
    this.onCancel();
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this._snackBar.open('Sucesso ao salvar curso', '', {duration: 5000});
  }

  private onError() {
    this._snackBar.open('Erro ao salvar curso', '', {duration: 5000});
  }

}
