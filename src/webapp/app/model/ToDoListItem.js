Ext.define(appName + '.model.ToDoListItem', {
	extend	    : 'Ext.data.Model',
	idProperty  : 'toDoListItemId',
	fields	    : [
		{ name : 'toDoListItemId',           type : 'int' },
        { name : 'toDoListItemName',          type : 'string' }
        { name : 'itemDescription',          type : 'string' }
        { name : 'itemDeadline',          type : 'date' }
        { name : 'itemStatus',          type : 'string' }
        { name : 'itemCreateDate',          type : 'date' }
        { name : 'toDoListId',          type : 'int' }

	]
});