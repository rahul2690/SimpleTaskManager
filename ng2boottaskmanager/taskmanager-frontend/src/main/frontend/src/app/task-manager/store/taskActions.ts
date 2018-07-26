// Section 1
import { Injectable } from '@angular/core'
import { Action } from '@ngrx/store'
import {Task} from '../../shared/dto';
import { UpdateTaskPayload } from 'app/shared/payload';

// Section 2
export const GET_ALL_TASKS  = '[Task] GetAll'
export const POPULATE_TASKS = '[Task] Populate'
export const GET_TASK       = '[Task] Get'
export const UPDATE_TASK    = '[Task] Update'

// Section 3
export class GetAllTasks implements Action {
    readonly type = GET_ALL_TASKS

    constructor() {} 
}

export class PopulateTasks implements Action {
    readonly type = POPULATE_TASKS

    constructor(public payload: Task[]) {} 
}

export class UpdateTask implements Action {
    readonly type = UPDATE_TASK

    constructor(public payload: UpdateTaskPayload) {} 
}

export class GetTask implements Action {
    readonly type = GET_TASK

    constructor(public payload: Task) {}
}

// Section 4
export type Actions = GetAllTasks | UpdateTask | GetTask | PopulateTasks