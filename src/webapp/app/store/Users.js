Ext.define(appName + '.store.Users', {
	extend		: 'Ext.data.Store',
	model		: appName + '.model.User',
	autoLoad	: false,
	autoSync	: false,
    remoteSort	: false,
	proxy		: {
		type	: 'ajax',
		api		: {
			read	: 'loadUser.ajax'  /// bu nası çalışıyo ya
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