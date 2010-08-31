package com.cloud.api.response;

import java.util.Date;

import com.cloud.api.ResponseObject;
import com.cloud.host.Host;
import com.cloud.host.Status;
import com.cloud.hypervisor.Hypervisor;
import com.cloud.serializer.Param;

public class HostResponse implements ResponseObject {
    @Param(name="id")
    private Long id;

    @Param(name="name")
    private String name;

    @Param(name="state")
    private Status state;

    @Param(name="disconnected")
    private Date disconnectedOn;

    @Param(name="type")
    private Host.Type hostType;

    @Param(name="oscategoryid")
    private Long osCategoryId;

    @Param(name="oscategoryname")
    private String osCategoryName;

    @Param(name="ipaddress")
    private String ipAddress;

    @Param(name="zoneid")
    private Long zoneId;

    @Param(name="zonename")
    private String zoneName;

    @Param(name="podid")
    private Long podId;

    @Param(name="podname")
    private String podName;

    @Param(name="version")
    private String version;

    @Param(name="hypervisor")
    private Hypervisor.Type hypervisor;

    @Param(name="cpunumber")
    private Integer cpuNumber;

    @Param(name="cpuspeed")
    private Long cpuSpeed;

    @Param(name="cpuallocated")
    private String cpuAllocated;

    @Param(name="cpuused")
    private String cpuUsed;

    @Param(name="averageload")
    private Long averageLoad;

    @Param(name="networkkbsread")
    private Long networkKbsRead;

    @Param(name="networkkbswrite")
    private Long networkKbsWrite;

    @Param(name="memorytotal")
    private Long memoryTotal;

    @Param(name="memoryallocated")
    private Long memoryAllocated;

    @Param(name="memoryused")
    private Long memoryUsed;

    @Param(name="disksizetotal")
    private Long diskSizeTotal;

    @Param(name="disksizeallocated")
    private Long diskSizeAllocated;

    @Param(name="capabilities")
    private String capabilities;

    @Param(name="lastpinged")
    private Date lastPinged;

    @Param(name="managementserverid")
    private Long managementServerId;

    @Param(name="custerid")
    private Long clusterId;

    @Param(name="clustername")
    private String clusterName;

    @Param(name="islocalstorageactive")
    private Boolean localStorageActive;

    @Param(name="created")
    private Date created;

    @Param(name="removed")
    private Date removed;

    @Param(name="events")
    private String events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public Date getDisconnectedOn() {
        return disconnectedOn;
    }

    public void setDisconnectedOn(Date disconnectedOn) {
        this.disconnectedOn = disconnectedOn;
    }

    public Host.Type getHostType() {
        return hostType;
    }

    public void setHostType(Host.Type hostType) {
        this.hostType = hostType;
    }

    public Long getOsCategoryId() {
        return osCategoryId;
    }

    public void setOsCategoryId(Long osCategoryId) {
        this.osCategoryId = osCategoryId;
    }

    public String getOsCategoryName() {
        return osCategoryName;
    }

    public void setOsCategoryName(String osCategoryName) {
        this.osCategoryName = osCategoryName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getPodId() {
        return podId;
    }

    public void setPodId(Long podId) {
        this.podId = podId;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Hypervisor.Type getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(Hypervisor.Type hypervisor) {
        this.hypervisor = hypervisor;
    }

    public Integer getCpuNumber() {
        return cpuNumber;
    }

    public void setCpuNumber(Integer cpuNumber) {
        this.cpuNumber = cpuNumber;
    }

    public Long getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Long cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuAllocated() {
        return cpuAllocated;
    }

    public void setCpuAllocated(String cpuAllocated) {
        this.cpuAllocated = cpuAllocated;
    }

    public String getCpuUsed() {
        return cpuUsed;
    }

    public void setCpuUsed(String cpuUsed) {
        this.cpuUsed = cpuUsed;
    }

    public Long getAverageLoad() {
        return averageLoad;
    }

    public void setAverageLoad(Long averageLoad) {
        this.averageLoad = averageLoad;
    }

    public Long getNetworkKbsRead() {
        return networkKbsRead;
    }

    public void setNetworkKbsRead(Long networkKbsRead) {
        this.networkKbsRead = networkKbsRead;
    }

    public Long getNetworkKbsWrite() {
        return networkKbsWrite;
    }

    public void setNetworkKbsWrite(Long networkKbsWrite) {
        this.networkKbsWrite = networkKbsWrite;
    }

    public Long getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(Long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public Long getMemoryAllocated() {
        return memoryAllocated;
    }

    public void setMemoryAllocated(Long memoryAllocated) {
        this.memoryAllocated = memoryAllocated;
    }

    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public Long getDiskSizeTotal() {
        return diskSizeTotal;
    }

    public void setDiskSizeTotal(Long diskSizeTotal) {
        this.diskSizeTotal = diskSizeTotal;
    }

    public Long getDiskSizeAllocated() {
        return diskSizeAllocated;
    }

    public void setDiskSizeAllocated(Long diskSizeAllocated) {
        this.diskSizeAllocated = diskSizeAllocated;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public Date getLastPinged() {
        return lastPinged;
    }

    public void setLastPinged(Date lastPinged) {
        this.lastPinged = lastPinged;
    }

    public Long getManagementServerId() {
        return managementServerId;
    }

    public void setManagementServerId(Long managementServerId) {
        this.managementServerId = managementServerId;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Boolean isLocalStorageActive() {
        return localStorageActive;
    }

    public void setLocalStorageActive(Boolean localStorageActive) {
        this.localStorageActive = localStorageActive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getRemoved() {
        return removed;
    }

    public void setRemoved(Date removed) {
        this.removed = removed;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
