Ext.define(appName + '.store.ToDoLists', {
	extend		: 'Ext.data.Store',
	model		: appName + '.model.ToDoList',
	autoLoad	: false,
	autoSync	: false,
    remoteSort	: false,
	proxy		: {
		type	: 'ajax',
		api		: {
			read	: 'loadToDoList.ajax'
		},
		reader	: {
			type	        : 'json',
			rootProperty    : 'data',
			successProperty : 'success',
			totalProperty	: 'totalCount'
		},
		writer	: {
			type	        : 'json',
			writeAllFields  : true,
			encode	        : true,
			rootProperty	: 'data'
		}
	}
});