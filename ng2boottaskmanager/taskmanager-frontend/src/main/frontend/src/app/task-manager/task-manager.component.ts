import { Component, OnInit } from '@angular/core';
import { Actions } from '@ngrx/effects';
import { Action, Store } from '@ngrx/store';
import { AppState } from './store/taskState';
import { GetAllTasks, UpdateTask } from './store/taskActions';
import { Task } from 'app/shared/dto';
import { UpdateTaskPayload } from 'app/shared/payload';
import { DatePipe } from '@angular/common';

import { ClrDatagridStringFilterInterface } from "@clr/angular";

@Component({
  selector: 'app-task-manager',
  templateUrl: './task-manager.component.html',
  styleUrls: ['./task-manager.component.scss']
})
export class TaskManagerComponent implements OnInit {

  constructor(private store: Store<AppState>) {

  }

  statuses: any = ["NOT_STARTED", "INPROGRESS", "FINISHED"];
  priorities: any = ["LOW", "MEDIUM", "HIGH"];

  tasks: any = [];
  loading: boolean = true;;
  basic = false
  ngOnInit() {

    this.store.dispatch(new GetAllTasks());
    const domainSubscription = this.store.select('task').subscribe((state: Task[]) => {
      this.loading = false;

      if (state.length > 1) {
        this.tasks = state;
      }
    },
      error => {
        this.loading = false;        
        console.log("request Completed with error " + error);
      },
      () => {
        this.loading = false;
      }
    );

  }

  getAllTasksLatest() {
    this.loading = true;

    this.store.dispatch(new GetAllTasks());
  }

  taskToUpdate: Task;
  udateTask(task: Task) {
    // this.taskToUpdate = task;
    var tempTaskToUpdate: Task = {
      id: task.id,
      title: task.title,
      description: task.description,
      priority: task.priority,
      taskStatus: task.taskStatus,
      dueDate: task.dueDate,
      remindeMeAT: task.remindeMeAT

    }
    this.taskToUpdate = tempTaskToUpdate;

    this.basic = true;

  }

  /**
   * On Modal Ok Click
   * Close Modal
   * Update the Task
   * Then dispatch action to update the task
   * That in turn will Load new tasks
   * Set Loading True
   */
  onModalOk() {
    this.basic = false;

    //Create Payload
    const dtos: Task = {
      title: this.taskToUpdate.title,
      description: this.taskToUpdate.description,
      priority: this.taskToUpdate.priority,
      taskStatus: this.taskToUpdate.taskStatus,
      dueDate: this.taskToUpdate.dueDate,
      remindeMeAT: this.taskToUpdate.remindeMeAT

    }

    const updatePayload: UpdateTaskPayload = {
      request: dtos,
      pathParams: { 'task_id': this.taskToUpdate.id }

    }
    //Update Tasl
    this.store.dispatch(new UpdateTask(updatePayload))
    this.loading = true;
  }

  /**
   * On Modal Cancel click
   * Close Modal
   * Set Loading False
   */
  onModalCancel() {
    this.basic = false;
    this.loading = false;
  }
}
