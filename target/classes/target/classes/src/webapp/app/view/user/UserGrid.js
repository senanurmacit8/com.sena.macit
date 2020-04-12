Ext.define(appName + '.view.user.UserGrid', {
    extend      : 'Ext.grid.Panel',
    alias       : 'widget.usergrid',
    title       : 'Users',
    glyph       : '',
    store       : 'Users',
    forceFit    : true,
    border      : true,
    autoScroll  : true,
    headerBorders: false,
    viewConfig  : {
        stripeRows  : true,
        emptyText   : '<span class="x-grid-empty">Görüntülenecek veri bulunamadı.</span>',
        enableTextSelection: false,
        loadMask    : false
    },
    selModel    : 'rowmodel',
    initComponent: function() {

        var me = this;

        this.selType = 'rowmodel';

        this.columns = [{
            xtype   : 'rownumberer',
            align   : 'center'
        }, {
            header  : 'Adı',
            dataIndex: 'username',
            sortable: false,
            flex    : 1
        }, {
            header  : 'Soyadı',
            dataIndex: 'userLastname',
            sortable: false,
            flex    : 1
        },  {
            xtype       : 'actioncolumn',
            align       : 'center',
            sortable    : false,
            menuDisabled: true,
            items       : [{
                iconCls : 'icon-delete',
                tooltip : 'Sil',
                handler : function(grid, rowIndex, colIndex, node, e, record, rowNode) {
                    var action = 'delete';
                    this.fireEvent('itemclick', this, action, grid, rowIndex, colIndex, record, node);
                }
            }]
        }];

       this.callParent(arguments);
    }
});