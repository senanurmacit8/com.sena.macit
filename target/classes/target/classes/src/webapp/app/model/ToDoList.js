Ext.define(appName + '.model.ToDoList', {
	extend	    : 'Ext.data.Model',
	idProperty  : 'toDoListId',
	fields	    : [
		{ name : 'toDoListId',           type : 'int' },
        { name : 'toDoListName',          type : 'string' }
        { name : 'userId',          type : 'int' }
        { name : 'toDoListItemId',          type : 'int' }
        { name : 'dependedItemId',          type : 'int' }
        { name : 'is_Completed',          type : 'boolean' }
	]
});