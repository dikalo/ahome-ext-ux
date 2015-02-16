/**
 * @class Ext.ux.ActivityMonitor
 * @author Arthur Kay (http://www.akawebdesign.com)
 * @singleton
 * @version 1.0
 *
 * GitHub Project: https://github.com/arthurakay/ExtJS-Activity-Monitor
 */
Ext.define('Ext.ux.ActivityMonitor', {
    singleton   : true,


    ui          : null,
    runner      : null,
    task        : null,
    lastActive  : null,
    
    ready       : false,
    verbose     : false,
    interval    : (1000 * 60 * 1), //1 minute
    maxInactive : (1000 * 60 * 30), //30 minutes
    mouseEvent  : 'mouseover',
    secondsUntilInactive: 0,
    secondsSinceLastActivity: 0,
    
    init : function(config) {
        if (!config) { config = {}; }
        
        Ext.apply(this, config, {
            runner     : new Ext.util.TaskRunner(),
            ui         : Ext.getBody(),
            task       : {
                run      : this.monitorUI,
                interval : config.interval || this.interval,
                scope    : this
            }
        });
        this.secondsUntilInactive = this.maxInactive;
        
        this.ready = true;
    },
    
    isReady : function() {
        return this.ready;
    },
    
    isActive   : Ext.emptyFn,
    isInactive : Ext.emptyFn,
    
    start : function() {
        var me = this;
        
        if (!me.isReady()) {
            me.log('Please run ActivityMonitor.init()');
            return false;
        }
        /**
         * we changed this from ousemove to mousedown
         * to be less cpu consumming
         */
        me.ui.on(me.mouseEvent, me.captureActivity, me);
        me.ui.on('keydown', me.captureActivity, me);
        
        me.lastActive = new Date();
        me.log('ActivityMonitor has been started.');
        
        me.runner.start(me.task);
        return true;
    },
    
    stop : function() {
        var me = this;
        
        if (!me.isReady()) {
            me.log('Please run ActivityMonitor.init()');
            return false;
        }
        
        me.runner.stop(me.task);
        me.lastActive = null;
        
        me.ui.un(me.mouseEvent, me.captureActivity);
        me.ui.un('keydown', me.captureActivity);
        
        me.log('ActivityMonitor has been stopped.');
        return true;
    },
    
    captureActivity : function(eventObj, el, eventOptions) {
        this.lastActive = new Date();
    },
    
    monitorUI : function() {
        var now      = new Date(),
            inactive = (now - this.lastActive);
        
        this.secondsSinceLastActivity = (inactive / 1000).toFixed();
        this.secondsUntilInactive = (this.maxInactive / 1000).toFixed() - this.secondsSinceLastActivity;
        if (inactive >= this.maxInactive) {
            this.log('MAXIMUM INACTIVE TIME HAS BEEN REACHED');
             this.stop(); //remove event listeners
            
            this.isInactive();
        }
        else {
            this.log('CURRENTLY INACTIVE FOR ' + inactive + ' (ms)');
            this.isActive();
        }        
    },
    
    log : function(msg) {
        if (this.verbose) {
            if(window.console){
                window.console.log(msg);
            }
            Ext.log(msg);
        }
    }
    
});