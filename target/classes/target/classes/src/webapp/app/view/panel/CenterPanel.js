Ext.define(appName + '.view.panel.CenterPanel', {
    header      : false,
    glyph       : 'xE851@Material Icons',
    extend      : 'Ext.panel.Panel',
    alias       : 'widget.centerpanel',
    layout      : {
        type    : 'hbox',
        align   : 'stretch'
    },
    initComponent: function() {

        this.form = Ext.create(appName + '.view.user.UserForm', {
            flex    : 1
        });
        this.panel = Ext.create(appName + '.view.user.UserGrid', {
            flex    : 2
        });

        this.items = [this.form, this.panel];

        this.callParent(arguments);
    }
});