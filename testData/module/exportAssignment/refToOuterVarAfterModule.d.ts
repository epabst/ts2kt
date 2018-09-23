// based on jquery.d.ts
interface JQueryAjaxSettings
interface JQueryXHR
interface JQueryStatic {
    ajax(settings: JQueryAjaxSettings): JQueryXHR;
    ajax(url: string, settings?: JQueryAjaxSettings): JQueryXHR;
}

declare module "jquery" {
    export = $;
}
declare var $: JQueryStatic;
