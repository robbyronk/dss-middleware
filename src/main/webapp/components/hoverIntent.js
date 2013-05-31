'use strict';

(function(a) {
	a.fn.hoverIntent=function(l,j) {
		var m = {sensitivity:7,interval:100,timeout:0};
		m = a.extend(m, j?{over:l,out:j}:l);
		var o,n,h,d;
		var e = function(f) {
			o = f.pageX;
			n = f.pageY;
		};
		var c = function(g, f) {
			f.hoverIntent_t = clearTimeout(f.hoverIntent_t);
			if((Math.abs(h - o) + Math.abs(d - n)) < m.sensitivity) {
				a(f).unbind("mousemove", e);
				f.hoverIntent_s = 1;
				return m.over.apply(f, [g]);
			}
			else {
				h = o;
				d = n;
				f.hoverIntent_t = setTimeout(function() {c(g,f);}, m.interval);
			}
		};
		var i = function(g, f) {
			f.hoverIntent_t = clearTimeout(f.hoverIntent_t);
			f.hoverIntent_s = 0;
			return m.out.apply(f, [g]);
		};
		var b = function(q) { 
			var f = this;
			var g = (q.type == "mouseover"?q.fromElement:q.toElement) || q.relatedTarget;
			while(g && g != this) { 
				try {
					g = g.parentNode;
				} catch(q) {
					g = this;
				}
			}
			if(g == this) {
				if(a.browser.mozilla) {
					if(q.type == "mouseout") {
						f.mtout = setTimeout(function() {k(q,f);}, 30);
					}
					else {
						if(f.mtout) {
							f.mtout = clearTimeout(f.mtout);
						}
					}
				}
				return;
			}
			else {
				if(f.mtout) {
					f.mtout = clearTimeout(f.mtout);
				}
				k(q,f);
			}
		};
		var k = function(p,f) {
			var g = jQuery.extend({}, p);
			if(f.hoverIntent_t) {
				f.hoverIntent_t = clearTimeout(f.hoverIntent_t);
			}
			if(p.type == "mouseover") { 
				h = g.pageX;
				d = g.pageY;
				a(f).bind("mousemove", e);
				if(f.hoverIntent_s != 1) {
					f.hoverIntent_t = setTimeout(function() {c(g,f);}, m.interval);
				}
			}
			else {
				a(f).unbind("mousemove", e);
				if(f.hoverIntent_s == 1) {
					f.hoverIntent_t = setTimeout(function() {i(g,f);}, m.timeout);
				}
			}
		};
		return this.mouseover(b).mouseout(b);
	};
})(jQuery);