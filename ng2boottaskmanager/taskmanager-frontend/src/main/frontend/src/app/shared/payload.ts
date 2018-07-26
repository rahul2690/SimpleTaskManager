import * as dto from './dto';

/**
 * Payload to get individual task
 */
export interface GetTaskPayload {
    pathParams: {'task_id': string};
    response?: dto.Task;
  }

/**
 * Payload to update task
 */
  export interface UpdateTaskPayload {
    request: dto.Task;
    pathParams: {'task_id': string};
    response?: dto.Task;
  }
  
  