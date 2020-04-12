Ext.define(appName + '.view.toDoList.ToDoListCombo', {
    extend		: 'Ext.form.field.ComboBox',
    alias		: 'widget.toDoListCombo',
    triggerAction:  'all',
    forceSelection: true,
    editable    : false,
    queryMode	: 'local',
    displayField: 'toDoListName',
    valueField	: 'toDoListId',
    store       : 'ToDoLists',
    initComponent: function() {

        this.on('added', function(combo, container, pos, eOpts) {
            combo.getStore().load();
        });

        this.callParent(arguments);
    }
});