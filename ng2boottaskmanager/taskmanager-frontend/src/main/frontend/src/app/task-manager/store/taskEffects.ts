import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Actions, Effect } from '@ngrx/effects';
import { Action, Store } from '@ngrx/store';
import * as _ from 'lodash';
import { Observable } from 'rxjs/Observable';
import {catchError} from 'rxjs/operators';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/switchMap';
import { Task } from '../../shared/dto';
import * as TaskActions from './taskActions'
import {
  GET_ALL_TASKS,
  GET_TASK,
  UPDATE_TASK
} from './taskActions';
import { GetTaskPayload } from '../../shared/payload';
import { TaskManagerApi } from '../../shared/routine';

@Injectable()
export class TaskEffects {

  constructor(private actions$: Actions, private taskManagerApi: TaskManagerApi) {
  }

  @Effect()
  getTasks$: Observable<Action> = this.actions$
    .ofType<TaskActions.GetAllTasks>(GET_ALL_TASKS)
    .switchMap(() => {
      return this.taskManagerApi
        .listAllTasks()
        .map((response: any) => new TaskActions.PopulateTasks(
          response
        ))
       .pipe(catchError((err) => Observable.throw("Server Did Not Respond Correctly for Get ")));
    });

  @Effect()
  updateTasks$: Observable<Action> = this.actions$
    .ofType<TaskActions.UpdateTask>(UPDATE_TASK)
    .map(action => action.payload)
    .switchMap(payload => {
      return this.taskManagerApi
        .updateTask(payload)
        .map((response: any) => new TaskActions.GetAllTasks(

        ))
        .pipe(catchError((err) => Observable.throw("Server Did Not Respond Correctly for Fost ")));
      });
}