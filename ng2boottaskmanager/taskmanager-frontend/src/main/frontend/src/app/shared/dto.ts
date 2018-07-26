export interface Task {
    id?: string;
    title?: string;
    description?: string;
    priority?: 'HIGH' |'MEDIUM' |'LOW';
    taskStatus?: 'NOT_STARTED' | 'INPROGRESS' | 'FINISHED';
    createdDate?: string;
    lastUpdatedDate?: string;
    resolvedAt?: string;
    dueDate?: string;
    remindeMeAT?: string;
  }