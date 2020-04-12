Ext.define(appName + '.view.user.UserForm', {
    extend          : 'Ext.form.Panel',
    id              : 'myform',
    alias           : 'widget.userForm',
    title           : 'User Kayıt Formu',
    glyph           : 'xE87C@Material Icons',
    autoScroll      : true,
    monitorValid    : true,
    defaultType     : 'textfield',
    buttonAlign     : 'center',
    fieldDefaults: {
        labelWidth  : 150,
        labelStyle  : 'font-weight: bold;',
        allowBlank  : false,
        anchor      : '95%',
        msgTarget   : 'under',
        padding 	: '10 0 0 15'
    },
    initComponent   : function() {

        this.items = [{
            xtype       : 'hidden',
            name        : 'userId'
        }, {
            fieldLabel  : 'Adı',
            name        : 'username'
        }, {
            fieldLabel  : 'Soyadı',
            name        : 'userLastname'
        }, {
            fieldLabel  : 'User no',
            name        : 'userNo',
            hideTrigger : true,
            xtype       : 'numberfield',
            allowDecimals: false,
            minValue    : 1
        }, {
                       fieldLabel  : 'parola',
                       name        : 'userPassword'
                   }, /*{
            fieldLabel  : 'Sınıfı',
            name        : 'sinifi',
            xtype       : 'sinifcombo'
        }, {
            fieldLabel  : 'Adres',
            name        : 'adres',
            xtype       : 'textareafield',
            grow        : true
        }, {
            fieldLabel  : 'E-posta',
            name        : 'email',
            allowBlank  : true,
            vtype       : 'email'
        }, {
            fieldLabel  : 'Programlama Dili',
            name        : 'cb',
            allowBlank  : true,
            xtype       : 'checkboxgroup',
            columns     : 1,
            items       : [
                { boxLabel  : 'Java',   name: 'programlamaDili', inputValue: '1' },
                { boxLabel  : 'C',      name: 'programlamaDili', inputValue: '2' },
                { boxLabel  : 'PHP',    name: 'programlamaDili', inputValue: '3' }
            ]
        }, {
            fieldLabel  : 'Öğrenim Grubu',
            columns     : 1,
            xtype       : 'radiogroup',
            items       : [
                { boxLabel: 'Normal Öğretim', name: 'ogrenimGrubu', inputValue: 1, checked: true },
                { boxLabel: 'İkinci Öğretim', name: 'ogrenimGrubu', inputValue: 2 }
            ]
        }, {
            fieldLabel		: 'Bölümü',
            xtype           : 'bolumcombo',
            name			: 'bolumId'
        }, */{
            fieldLabel		: 'ToDoList',
            xtype           : 'toDoListCombo',
            allowBlank      : true,
            name			: 'toDoListId'
        }];

        this.btnKaydet = Ext.create('Ext.Button', {
            text        : 'Kaydet',
            glyph       : 'xE161@Material Icons',
            formBind    : true,
            action      : 'kaydet'
        });

        this.buttons = [this.btnKaydet];

        this.callParent(arguments);
    }
});