FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


KERNEL_DEVICETREE = " \
    am335x-osd3358-blackmagic.dtb \
"

SRC_URI += "file://defconfig \
            file://0001-Add-custom-devicetree-for-blackmagic-board.patch \
            "
SRC_URI += "file://wf111.cfg"

do_configure_append() {
        cat ../*.cfg >> ${B}/.config
}