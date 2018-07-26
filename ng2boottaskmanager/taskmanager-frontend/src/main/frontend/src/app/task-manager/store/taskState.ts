import { Task} from '../../shared/dto';

export interface AppState {
  readonly task: Task[];
}