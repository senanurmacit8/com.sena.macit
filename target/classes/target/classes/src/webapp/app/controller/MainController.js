Ext.define(appName + '.controller.MainController', {
    extend      : 'Ext.app.Controller',
    models      : [ 'User', 'ToDoList', 'ToDoListItem' ],
    stores      : [ 'Users', 'ToDoLists', 'ToDoListItems' ],
    views       : [ 'user.ToDoListCombo', 'user.UserForm', 'user.UserGrid', 'toDoList.ToDoListCombo',
        'ToDoListItem.ToDoListItemCombo' ],
    refs		: [{
        ref		: 'userGrid',
        selector: 'userGrid'
    }, {
        ref		: 'userForm',
        selector: 'userForm'
    }],
    init        : function() {
        this.control({
            'userGrid' : {
                viewready   : this.gridViewReady,
                selectionchange: this.userGridSelectionChange
            },
            'Usergrid actioncolumn' : {
                itemclick   : this.userGridActions
            },
            'userForm button[action=save]': {
                click       : this.saveOrUpdateUser
            }
        });
    },


    gridViewReady : function(grid) {
        grid.getStore().load();
    },


    userGridSelectionChange : function(selModel, selections, eOpts) {
        var userForm = this.getUserForm();
        if(selections.length > 0) {
            var record = selections[0];
            userForm.getForm().loadRecord(record);
        }
    },


    userGridActions : function(column, action, grid, rowIndex, colIndex, record, node) {
        if(action == 'delete') {
            Ext.Msg.confirm('Emin misiniz?', 'Öğrenciyi <span style="font-weight: bold;">silmek</span> istediğinizden emin misiniz?', function(btn) {
                if (btn == 'yes') {
                    Ext.Ajax.request({
                        url     : 'deleteUser.ajax',
                        method  : 'POST',
                        params  : {
                            userId : record.get('userId')
                        },
                        success : function(response, options) {
                            var res = Ext.decode(response.responseText);
                            if (res.success) {
                                grid.getStore().reload();
                            }
                        }
                    });
                }else {
                            Ext.Msg.confirm('silmedin') {

                }
            });
        }
    },


    saveOrUpdateUser : function(btn) {
        var grid = this.getUserGrid();
        var form = btn.up('form');
        Ext.Ajax.request({
            url     : 'saveOrUpdateUser.ajax',
            method  : 'POST',
            params  : {
                data: Ext.encode(form.getForm().getValues())
            },
            success : function(response, options) {
                var res = Ext.decode(response.responseText);
                if (res.success) {
                    Ext.Msg.show({
                        title   : 'Başarılı',
                        msg     : 'Kaydetme işlemi başarıyla tamamlandı.',
                        icon    : Ext.Msg.INFO,
                        buttons : Ext.Msg.OK
                    });
                    grid.getStore().reload();
                    form.getForm().reset();
                }
            }
        });
    }
});