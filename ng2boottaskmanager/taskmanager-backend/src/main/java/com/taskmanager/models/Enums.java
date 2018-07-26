package com.taskmanager.models;

public class Enums {

	public enum Priortiy {
	    HIGH  (1),
	    MEDIUM(2),
	    LOW   (3)
	    ;
	    private final int levelCode;

	    Priortiy(int levelCode) {
	        this.levelCode = levelCode;
	    }

	    public int getLevelCode() {
	        return this.levelCode;
	    }
	}

	public enum TaskStatus{
		NOT_STARTED (1),
		INPROGRESS (2),
		FINISHED (3)
		;

		private final int levelCode;

		TaskStatus(int levelCode) {
	        this.levelCode = levelCode;
	    }

	    public int getLevelCode() {
	        return this.levelCode;
	    }
	}

}
