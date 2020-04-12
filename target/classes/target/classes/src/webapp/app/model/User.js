Ext.define(appName + '.model.USer', {
	extend	    : 'Ext.data.Model',
	idProperty  : 'userId',
	fields	    : [
		{ name : 'userId',       type : 'int' },
        { name : 'userNo',       type : 'int' },
        { name : 'username',             type : 'string' },
        { name : 'userLastname',          type : 'string' },
        { name : 'userPassword',          type : 'string' },
        { name : 'toDoListId',         type : 'int' },
	]
});