Ext.define(appName + '.view.panel.SouthPanel', {
    preventHeader: true,
    header      : false,
    glyph       : 'xE851@Material Icons',
    extend      : 'Ext.panel.Panel',
    alias       : 'widget.southpanel',
    layout      : {
        type    : 'hbox',
        align   : 'center',
        pack    : 'center'
    },
    initComponent: function() {

        this.items = [{
            xtype       : 'displayfield',
            value       : 'Burası south panel'
        }];

        this.callParent(arguments);
    }
});