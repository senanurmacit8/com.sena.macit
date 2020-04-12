Ext.define(appName + '.store.ToDoListItems', {
	extend		: 'Ext.data.Store',
	model		: appName + '.model.ToDoListItem',
	autoLoad	: false,
	autoSync	: false,
    remoteSort	: false,
	proxy		: {
		type	: 'ajax',
		api		: {
			read	: 'loadToDoListItem.ajax'
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