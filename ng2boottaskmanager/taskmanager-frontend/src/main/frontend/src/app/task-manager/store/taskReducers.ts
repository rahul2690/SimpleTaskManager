import { Action } from '@ngrx/store'
import { Task } from '../../shared/dto';
import * as TaskActions from './taskActions'
import { GetTaskPayload } from '../../shared/payload';


// Section 1
export function reducer(state: Task[], action: TaskActions.Actions) {

    // Section 2
    switch (action.type) {
        case TaskActions.GET_ALL_TASKS:
            console.log("get all")

            return [state];

        case TaskActions.POPULATE_TASKS:
            const varc = <Task[]>action.payload
            state = varc
            console.log("Total Tasks " + state.length)

            return [...state];


        case TaskActions.GET_TASK:
            console.log("Got Task ");
            const payload: Task = <Task>action.payload;

            return payload;

        case TaskActions.UPDATE_TASK:
             console.log("Update Task ");
             const updatedTask: Task = <Task>action.payload;
             
            return updatedTask;

        default:
            console.log("Default state");

            return state;
    }
}