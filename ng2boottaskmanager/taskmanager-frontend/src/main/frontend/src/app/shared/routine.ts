import { HttpClient } from '@angular/common/http';
import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map'
import * as dto from './dto';
import { UpdateTaskPayload, GetTaskPayload } from 'app/shared/payload';
//import * as fromPayload from './payload';


@Injectable()
export class TaskManagerApi {
  constructor(
    private http: HttpClient
  ) { }

  baseUrl: String = "http://" + window.location.hostname + ":8080";

  //Get All Tasks
  listAllTasks(options = {})
    : Observable<dto.Task[]> {
    let queryParams: HttpParams = new HttpParams();

    console.log("get all taks")
    const url = this.baseUrl + "/getTasks";
    return this.http.get(url, { ...options, params: queryParams })
      .map(response => <dto.Task[]>response);
  }

  //Currently Not Used, For sake of completion kept
  getTask(payload: GetTaskPayload, options = {})
    : Observable<dto.Task[]> {

    var url = this.baseUrl + "/getTask/<task_id>";
    url = url.split('/')
      .map((partKey) => {
        const partVal = payload.pathParams[partKey.replace(/[<>]+/g, '')]; return partVal ? partVal : partKey;
      })
      .join('/');

    return this.http.get(url, { ...options })
      .map(response => <dto.Task[]>response);
  }

  //Update task
  updateTask(payload: UpdateTaskPayload, options = {})
    : Observable<dto.Task> {

    var url = this.baseUrl + "/updateTask/<task_id>";

    url = url.split('/')
      .map((partKey) => {
        const partVal = payload.pathParams[partKey.replace(/[<>]+/g, '')]; return partVal ? partVal : partKey;
      })
      .join('/');
    console.log(url)
    return this.http.patch(url, payload.request, { ...options })
      .map(response => <dto.Task>response);
  }

}